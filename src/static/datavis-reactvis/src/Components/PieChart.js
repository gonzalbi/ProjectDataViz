import React, {Component} from 'react';
import {Hint,RadialChart} from 'react-vis';
// import gender from '../Img/gender.png';
import '../Css/pieChart.css'

class PieChart extends Component {

    state = {
        value: false
    };

    constructor(props){
        super(props)
    }



    render() {
        const {value} = this.state ;
        return (
            <div className={"pieChart"}> 
            <div className={"window_top"}> 
            <div className="window_icon_gender">
            </div>
            <div className={"titulo"}>Gender</div>
            </div>
                <RadialChart
                    width={250}
                    height={250}
                    showLabels={true}
                    animation={true}
                    data={this.props.data}
                    onValueMouseOver={v => this.setState({value: v})}
                    onSeriesMouseOut={v => this.setState({value: false})}
                >
                    {value !== false && <Hint value={{"Label" : value.label, "Quantity": value.quantity}} />}
                </RadialChart>
            </div>
        );
    }
}

export default PieChart;
