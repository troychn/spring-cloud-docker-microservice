/**
 * Created by zengqiuyan on 2017/3/19.
 */

var express = require('express');
var router = express.Router();

// 增加url 依赖
var urllib = require('url');

// 初始数据
var data = {
    status: '100',
    message: '操作成功',
    data: {
        commentId: '123456',
        userId: '2',
        productId: '1',
        commentContext: '这个品质不错，快递速度很快！'
    }
};

// 初始数据
var errorData = {
    status: '-1',
    message: '操作失败，参数不正确，请检查请求参数！',
    data: {}
};

/* GET home page. */
router.get('/', function (req, res, next) {
    res.writeHead(200, {'Content-Type': 'application/json; charset=utf-8'});
    var params = urllib.parse(req.url, true);
    var query2 = params.query;
    // 打印get请求中的接口参数
    console.log(query2);

    var productId = req.params.productId;

    /*if(productId != null){
        res.end(JSON.stringify(data));
    }  else {
        res.end(JSON.stringify(errorData));
    }*/
    res.end(JSON.stringify(data));

    //res.render('index', { title: 'Express' });
});

module.exports = router;
