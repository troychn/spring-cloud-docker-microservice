var express = require('express');
var router = express.Router();


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: '欢迎你使用评论系统！' });
});

module.exports = router;
