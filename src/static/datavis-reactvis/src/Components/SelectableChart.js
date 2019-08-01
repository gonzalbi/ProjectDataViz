import React, {Component} from 'react';
import '../Css/selectableChart.css'
import {  FlexibleXYPlot,
    XAxis,
    YAxis,
    AreaSeries,
    HorizontalGridLines,
    VerticalGridLines,
    LineSeries,
    Highlight
    } from 'react-vis';



class SelectableChart extends Component{

    constructor(props){
        super(props)
    }

    state = {
        selectionStart: null,
        selectionEnd: null
    };

    render(){

        const {selectionStart, selectionEnd} = this.state;
        // const updateDragState = area =>


        return (
            <div className={"selectableChart"}>
            <FlexibleXYPlot
                >
                <XAxis />
                <YAxis />
                <AreaSeries
                    animation
                    data={this.props.data}
                    opacity={0.5}
                />

                <Highlight
                    color="#829AE3"
                    drag
                    enableY={false}
                    onDragEnd={ (area ) => {
                        if(area != null) this.props.selectionHandler("height",[Math.round(area.left),Math.round(area.right)]);
                        if(area == null) this.props.selectionHandler("height",null)
                        this.setState({
                            selectionStart: area && area.left,
                            selectionEnd: area && area.right,
                        });
                    }}
                />
                </FlexibleXYPlot>
            </div>
        );
    }
}

/*<div>
    <b>selectionStart:</b> {`${Math.floor(selectionStart * 100) / 100},`}
    <b>selectionEnd:</b> {`${Math.floor(selectionEnd * 100) / 100},`}
</div>*/

export default SelectableChart;
