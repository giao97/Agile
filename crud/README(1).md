# Initialize the project
```shell
$ mkdir ./crud
$ cd ./crud
$ npm init -y
$ npm install --save express
$ npm install --save-dev nodemon
$ npm install --save-dev mocha
$ npm install --save-dev supertest
```

# Try the example
## 1. See https://expressjs.com/en/starter/hello-world.html
```javascript
const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => res.send('Hello World!'))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
```
## 2. Run the app.js by nodemon
Add a scirpt in the `package.json`:
```
  "scripts": {
    "start": "nodemon ./src/app.js",
    "debug": "DEBUG=express:* nodemon ./src/app.js",
    "test": "echo \"Error: no test specified\" && exit 1"
  }
```
Then run the following command in shell:
```shell
npm run debug
```
or
```shell
npm run start
```
## 3. Test by postman
