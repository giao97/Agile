import React, { Component } from 'react';
import "./ListItem.css"


class ListItem extends Component{

    constructor(props){
        super(props);
    }


    render(){
        const item = this.props.item;
        if (item.done){
            return <p className="done-item">{item.content}</p>
        } else {
            return <p className="item" onClick={this.props.changestatus}>{item.content}</p>
        }
    }
}

export default ListItem;