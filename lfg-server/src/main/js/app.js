const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {
	constructor(props) {
		super(props);
	}

	componentDidMount() {}

	render() {
		return (
		    <h1>MISE A JOUR EN DIRECT MA GUEULE!!</h1>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)