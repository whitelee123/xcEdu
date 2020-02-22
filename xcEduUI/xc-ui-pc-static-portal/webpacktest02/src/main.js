/**
 * Created by Administrator on 2018/6/24.
 */
//是webpack打包的入口文件
//目标：将各个项目所使用的依赖js文件进行打包，打包成一个文件
//要打包哪些文件：vue.min.js、module01.js
//导入这些文件
var Vue = require('./vue.min');

var {add} = require('./module01');

//新建一个vue实例(相当于MVVM模式中vm)
var VM = new Vue({
    el:"#app",//将上边视图部分app区域进行管理,将model数据和view进行绑定
    data:{//相当于MVVM中的model
        name:"黑马程序员",
        num1:0,
        num2:0,
        result:0,
        url:"http://www.itcast.cn"

    },
    methods:{
        change:function () {
            this.result =  add(Number.parseInt(this.num1),Number.parseInt(this.num2));
        }
    }

})
