import React from 'react';

class GameList extends React.Component {
	constructor(props) {
		super(props);
		this.state = {games: []};
	}

	componentDidMount() {
		fetch("http://localhost:8080/api/games")
		.then(result=>result.json())
		.then(games=>
			{	
				games.forEach(game=>this.addGameInGameList(game));
			})
	}


	addGameInGameList(game){
		this.setState(prevState => ({
			games: [...prevState.games, game]
		}))
	}

	render() {
		var nameList = this.state.games.map(
			(game,index)=>{
				var link = "#/games/"+game.id;
				return (
					<a key={index} href={link}>{game.name}</a>
				);
			}
		)
		console.log(nameList);
		return (
			<div>
				{nameList}
			</div>
		)
	}
};

export default GameList;