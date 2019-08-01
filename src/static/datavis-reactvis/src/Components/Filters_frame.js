import React, {Component} from 'react';
import Filter from './Filter';
import '../Css/Filters_frame.css'
import DoubleSlider from "./DoubleSlider";

class Filters_frame extends Component {


    constructor(props){
        super(props)
    }

    render() {

      return(
        <div className={"Filters_frame"}> 
          <div className={"window_top"}> 
            <div className={"window_icon_filter"}></div>
            <div className={"titulo"}>Filtros</div>
          </div>
            <div className={"filtersRow"}>
                {this.drawFilters()}
            </div>
        </div>
        );
    }

    drawFilters(){
        let filters = [];
        for(let key in this.props.selection_data){
            if(this.props.selection_data[key].type === "selection"){
                filters.push(<Filter selectionHandler={this.props.selectionHandler}
                                     id={key+"_filter"}
                                     element_key={key}
                                     label={this.props.selection_data[key].label}
                                     data={this.props.selection_data[key].values}
                                     selectedValues={this.props.selection_data[key].filterValues}
                />)
            }
            if(this.props.selection_data[key].type === "slider"){
                filters.push(<DoubleSlider
                    id={key+"_filter"}
                    element_key={key}
                    label={this.props.selection_data[key].label}
                    data={this.props.selection_data[key].values}
                />)
            }
        }
        return filters;
    }

}

export default Filters_frame;