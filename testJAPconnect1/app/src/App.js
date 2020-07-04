import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GameList from './GameList';
import GameEdit from './GameEdit';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/games' exact={true} component={GameList}/>
          <Route path='/games/:id' component={GameEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;