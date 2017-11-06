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
                // WINDOWS CREATION
                'md target\\classes\\static\\built',
                // LINUX
                // 'mkdir -p target/classes/static/built',
                'cp -r src/main/resources/static/built/* target/classes/static/built/'
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