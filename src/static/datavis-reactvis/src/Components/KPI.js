import React, {Component} from 'react';
import {Hint,RadialChart} from 'react-vis';
// import gender from '../Img/gender.png';
import '../Css/KPI.css'

class PieChart extends Component {

    state = {
        value: false
    };

    constructor(props){
        super(props)
    }

    render() {
        const {value} = this.state;
        return (
            <div className={"KPI"}> 
            <div className={"window_top"}> 
            <div className="window_icon_gender">
            </div>
            <div className={"titulo"}>{this.props.label}</div>
            </div>
            <div className={"valor"}>{this.props.data}</div>
            </div>
        );
    }
}

export default PieChart;
