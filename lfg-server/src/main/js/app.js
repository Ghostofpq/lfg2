const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {
	constructor(props) {
		super(props);
	}

	componentDidMount() {}

	render() {
		return (
		    <h1>Livereload is cool</h1>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)