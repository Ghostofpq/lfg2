import React from 'react';

class Game extends React.Component {
	constructor(props) {
		super(props);
		this.state={id:this.props.match.params.id};
	}

	componentDidMount() {
		fetch("http://localhost:8080/api/games/" + this.state.id)
		.then(result=>result.json())
		.then(game=>this.setState({name:game.name,description:game.description}))
	}

	render() {
		return (
			<div>
				<h1>{this.state.name}</h1>
				<span>{this.state.description}</span>
			</div>)
	}
};
export default Game;
