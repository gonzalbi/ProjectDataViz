import React, {Component} from 'react';
import '../Css/Header.css'

class Header extends Component {

    render() {

      return(
      	<div className={"Header"}> 
            <div className="window_icon_phoenix">
            </div>
            <div className="window_icons_menu">
                <div className="window_icon_download">
	            </div>
	            <div className="window_icon_dashboard">
	            </div>
	            <div className="window_icon_section">
	            </div>
	            <div className="window_icon_user">
	            </div>
            </div>
  		</div>
        );
    }
}

export default Header;
