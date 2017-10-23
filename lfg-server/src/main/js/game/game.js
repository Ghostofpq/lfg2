import React from 'react';

class Game extends React.Component {
	constructor(props) {
		super(props);
		this.state={id:this.props.match.params.id};
	}

	componentDidMount() {
		fetch("http://localhost:8080/api/games/" + this.state.id)
		.then(result=>result.json())
		.then(game=>			
			this.state={				
				name:game.name,
				description:game.description,		
			})
	}

	render() {
		return (<h1>{this.state.name}</h1>)
	}
};
export default Game;
