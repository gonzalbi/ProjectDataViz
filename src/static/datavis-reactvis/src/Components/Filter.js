import React, {Component} from 'react';
import '../Css/Filter.css'
import Select from 'react-select'

class Filter extends Component {

    constructor(props){
        super(props)
    }

    state={
        key : this.props.label
    }

    customStyles = {
        control: (base, state) => ({
            ...base,
            background: "#000103",
            color: "#FFF",
            border : "0px",
            borderBottom: "1px white solid",
            borderRadius : "0px",
            // match with the menu
            //borderRadius: state.isFocused ? "3px 3px 0 0" : 3,
            // Overwrittes the different states of border
            //borderColor: state.isFocused ? "yellow" : "green",
            // Removes weird border around container
            //boxShadow: state.isFocused ? null : null,
            "&:hover": {
                // Overwrittes the different states of border
              //  borderColor: state.isFocused ? "red" : "blue"
            }
        }),
        menu: base => ({
            ...base,
            // override border radius to match the box
            borderRadius: 0,
            // kill the gap
            marginTop: 0,
            background:  "#000103",
            color: "#FFF"
        }),
        menuList: base => ({
            ...base,
            // kill the white space on first and last option
            padding: 0,
            background:  "#000103",
            color: "#FFF"
        }),
        option : base =>({
            ...base,
            backgroundColor : "#000103",
            "&:hover": {
                backgroundColor: "red",
            }
        }),
        indicatorSeparator : base =>({
            ...base,
            display : "none",
        })
    }


    render() {
        return (
            <div className={"KPI"}>
                <p>{this.props.label}</p>
                <div className={"filterRow"}>
                <Select
                    id ={this.props.label}
                    styles={this.customStyles}
                    isMulti
                    placeholder={this.props.label}
                    value = {this.props.selectedValues.map(function (elem) {
                        return {value : elem, label: elem}
                    })}
                    onChange={(val,key) =>
                        {
                            let option = val != null ? val : null;
                            this.props.selectionHandler(this.props.element_key.toLowerCase(),option)
                        }
                    }
                    options={this.props.data.map(function (elem) {
                        return {value : elem, label: elem}
                    })}
                />
                </div>
            </div>
        );
    }

    handleChange(selectedOption){
        let key = this.key;
       this.props.selectionHandler(key,selectedOption);
    }
}

export default Filter;