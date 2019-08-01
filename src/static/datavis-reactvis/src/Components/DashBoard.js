import React, {Component} from 'react';
import '../../node_modules/react-vis/dist/style.css';
import "../Css/dashBoard.css"
import BarChart from './BarChart';
import Header from './Header';
import Filters_frame from './Filters_frame';
import PieChart from './PieChart';
import KPI from './KPI';
import SelectableChart from './SelectableChart';
import {SelectionHandler} from '../Controller/SelectionHandler';
import '../Css/pieChart.css'

let selection_handler = new SelectionHandler();


class DashBoard extends Component {

    constructor(props){
        super(props);
        this.selectionHandler = this.selectionHandler.bind(this);
    }

    async componentDidMount() {
        const response = await fetch('/data');
        let body = await response.json();
        selection_handler.init(body.Selection[0]);
        this.setState({
            dataLenght: body.dataLenght,
            isLoading: false,
            gender : body.gender,
            height : body.height,
            publisher : body.publisher,
            alignment : body.alignment,
            weight: body.weight,
            selectionHandler : this.selectionHandler.bind(this),
    });
    }

    state = {
        isLoading: true,
        data: [],
    };

    selectionHandler(key,value){
        if(value == null){
            //si es null entonces no esta filtrado
            selection_handler[key].filterValues = [];
        }else if(typeof value === "string") {
            //si es string se agrega a la lista
            if (selection_handler[key].filterValues.includes(value)) {
                selection_handler[key].filterValues.pop();
            } else {
                selection_handler[key].filterValues.push(value);
            }
        }else if(typeof value === "object") {
            value = value.map(x => x.value == null ? x : x.value);
            selection_handler[key].filterValues= value;
        }else{
            selection_handler[key].filterValues = value;
        }

        let post_data = {};
        for(let key in selection_handler){
            post_data[key] = selection_handler[key].filterValues
        }

        fetch(
            "/filterData",{
                method: 'POST',
                headers:{
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(post_data)
            }
        ).then(res => res.json())
            .then(response =>
                this.updateData(response),
            )
            .catch(error => console.error('Error:', error));


    }

    updateData(data){

        for(let key in selection_handler){
            if(selection_handler[key].filterValues.length > 0){
                data[key] = this.state[key];
            }
        }


        this.setState({
            dataLenght : data.dataLenght,
            height : data.height,
            publisher : data.publisher,
            alignment : data.alignment,
            weight : data.weight,
            gender : data.gender,
        })
    }

    render(){
        const isLoaded = !this.state.isLoading;

        return (
            isLoaded ?
            <div className={"dashboard"}>
                <Header />
                <div className={"charts"}>
                <Filters_frame selection_data={selection_handler} selectionHandler={this.selectionHandler} />
                <div className={"kpi_frame"}>
                    {this.drawKPIS()}
                </div>
                <PieChart data={this.state.gender} />
                <PieChart data={this.state.alignment} />
                <BarChart data={this.state.publisher} selectionHandler={this.selectionHandler}/>
                <SelectableChart data={this.state.height} selectionHandler={this.selectionHandler}/>
                <SelectableChart data={this.state.weight} selectionHandler={this.selectionHandler}/>
                </div>
                </div>
                : <div>{"Loading"}</div>
        )
    }

    drawKPIS(){

        let kpiList = [(<KPI data={this.state.dataLenght} label={"SuperHeroes"}/>)];

        /*for(let key in selection){
            let kpi = (<KPI data={this.state.data.length} label={key}/>);
            kpiList.push(kpi)
        }*/

        return kpiList;
    }

}

export default DashBoard;
