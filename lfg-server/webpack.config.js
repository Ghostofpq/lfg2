var path = require('path');
const WebpackShellPlugin = require('webpack-shell-plugin');

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    plugins: [
        new WebpackShellPlugin({
            onBuildExit: [
                'echo "Transfering files ... "',
                'cp -r src/main/resources/static/built/* target/classes/static/built/',
                'echo "DONE ... "'
            ]
        })
    ],
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ],

    }
};