import React, { Component } from 'react';
import ListItem from './ListItem';
import NewItem from './NewItem';

class TodoList extends Component {

    constructor(props){
        super(props);
        this.state = {
            todoList: [
            {content: "game time", done: true},
            {content: "react study", done: false}
            ]
        }
    }

    addNewItem = (newItemContent) =>{
        const newList = [...this.state.todoList, {content: newItemContent, done: false}];
        this.setState({
            todoList: newList
        })
    }

    changeStatus = (event) =>{
        const text = event.target.innerText;
        const index = this.state.todoList.findIndex(function(e){return e.content == text});
        let newList = this.state.todoList.filter((_,i) => i !== index);
        newList = [...newList, {content: text, done: true}];
        this.setState({
            todoList: newList
        })
    }

    render() {
        return(
            <div>
            {
                this.state.todoList.map(item => <ListItem changestatus={this.changeStatus} item={item}></ListItem>)
            }
            <NewItem addItem={this.addNewItem} />
            </div>
        );
    }
}

export default TodoList;