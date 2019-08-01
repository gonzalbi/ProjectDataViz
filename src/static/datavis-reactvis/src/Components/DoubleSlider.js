import React, {Component} from 'react';


class DoubleSlider extends Component {

    constructor(props) {
        super(props)
    }


    render(){
        return(
            <div className={"KPI"}>
                <p>{this.props.label}</p>
                <div className={"filterRow"}></div>
            </div>
        )
    }
}

export default DoubleSlider;
