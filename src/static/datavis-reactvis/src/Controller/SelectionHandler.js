
export class SelectionHandler{

    constructor(){
        this.gender = {label : "Gender", filtered : false, values: [], filterValues : [], type : "selection"};
        this.eyecolor = {label : "Eye Color", filtered : false, values: [], filterValues : [], type : "selection"};
        this.race = {label : "Race", filtered : false, values: [], filterValues : [], type : "selection"};
        this.haircolor = {label : "Hair Color", filtered : false, values: [], filterValues : [], type : "selection"};
        this.height = {label : "Height", filtered : false, values: [], filterValues : [], type : "slider"};
        this.publisher = {label : "Publisher", filtered : false, values: [], filterValues : [], type : "selection"};
        this.skincolor = {label : "Skin Color", filtered : false, values: [], filterValues : [], type : "selection"};
        this.alignment = {label : "Aligment", filtered : false, values: [], filterValues : [], type : "selection"};
        this.weight = {label : "Weight", filtered : false, values: [], filterValues : [], type : "slider"};
    }

    init(selection_data){
        for(let i in selection_data){
            this[i].values = selection_data[i];
        }
    }
}

