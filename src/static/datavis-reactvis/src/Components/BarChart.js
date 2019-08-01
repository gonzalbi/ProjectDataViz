import React, {Component} from 'react';
import '../Css/barChart.css'
import {FlexibleXYPlot , VerticalBarSeries,XAxis,YAxis,LabelSeries, VerticalGridLines,HorizontalGridLines} from 'react-vis';
//Editorial
class BarChart extends Component {

    constructor(props){
        super(props)
    }

    render() {

        return (
            <div className={"barChart_div"}> 
                <div className={"window_top"}>
                    <div className="window_icon_editorial">
                    </div>
                    <div className={"titulo"}>Editorial</div>
                </div>
                <FlexibleXYPlot
                        height = {400}
                        className={"barChart"}
                        xType="ordinal"
                        yDomain={[0,400]} animation={{damping: 9,stiffness: 300}}>
                    <HorizontalGridLines className={"horizontal_gridlines"}/>
                    <XAxis/>
                    <YAxis />
                    <VerticalBarSeries
                        data={this.props.data}
                        onValueClick={(datapoint,event)=>{
                            this.props.selectionHandler("publisher",datapoint.x);
                        }}
                    />
                    <LabelSeries
                        allowOffsetToBeReversed
                        data={this.props.data.map(obj => {
                            return { ...obj, label: obj.x.toString()}
                        })}
                        labelAnchorX="middle"
                        labelAnchorY="text-after-edge"
                    />
                </FlexibleXYPlot>
                </div>
        );
    }
}

export default BarChart;
