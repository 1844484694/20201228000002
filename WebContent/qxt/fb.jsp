<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
        body {
            margin: 0;
        }
        #main {
            height: 100%;
        }
    </style>
</head>
<body>
<div id="main"></div>
<script src="<%=request.getContextPath()%>/qxt/echarts.js"></script>
<script src="<%=request.getContextPath()%>/qxt/bmap.js"></script>
<script src="<%=request.getContextPath()%>/qxt/china.js"></script>
<script src="<%=request.getContextPath()%>/qxt/jquery-1.8.1.js"></script>
<script type="text/javascript">

var shengfenData=[];
var renshuData=[];

<c:forEach var="map" items="${list_fenbu}" >
shengfenData.push("${map.shengfen}");
renshuData.push("${map.renshu}");
</c:forEach>
var sum=0;
for(var i =0;i<renshuData.length;i++)
{
	sum=sum+parseInt(renshuData[i]);
}

var myChart = echarts.init(document.getElementById('main'));//获取绘图位置对象
function randomData() {
    return Math.round(Math.random()*1000);
}
//配置
option = {
    title: {
        x:'470px',
        text: '河北软件学院学生来源地理分布图',
        textStyle:{
            fontSize:14
            ,fontWeight:'normal'
            ,color:'#565656'
        },
        left:480,
        top:10,
        textStyle: {
        	// 颜色
        	color: '#0066FF',
        	// 水平对齐方式，可选为：'left' | 'right' | 'center'
        	align: 'left',
        	// 垂直对齐方式，可选为：'top' | 'bottom' | 'middle'
        	baseline: 'bottom',
        	// 字体系列
        	fontFamily: 'Arial, 黑体, sans-serif',
        	// 字号 ，单位px
        	fontSize: 20,
        	// 样式，可选为：'normal' | 'italic' | 'oblique'
        	fontStyle: 'italic',
        	// 粗细，可选为：'normal' | 'bold' | 'bolder' | 'lighter' | 100 | 200 |... | 900
        	fontWeight: 'bold'
        },
        
    },
    tooltip: {
         trigger: 'item'
        ,formatter:'{b}<br>人数：{c}'
    },

    visualMap: {
        min: 0,
        max: sum,
        left:20,
        bottom:10,
        text: ['高','低'],// 文本，默认为数值文本
        color:['red','orange','yellow','green'],
        calculable: true
    },
    series: [
        {
            type: 'map',// 图表类型
            mapType: 'china',//显示的类型为中国地图，备注e-charts是支持中国地图和世界地图的
            roam: false,//是否开启滑动鼠标滚轮实现缩放
            itemStyle:{
            	// 默认状态下地图的文字
                normal:{label:{show:true}},
              },
            data:[
                  
                {name: '北京',value: 0 },
                {name: '天津',value: 0 },
                {name: '上海',value: 0 },
                {name: '重庆',value: 0 },
                {name: '河北',value: renshuData[3] },
                {name: '安徽',value: renshuData[0] },
                {name: '新疆',value: 0 },
                {name: '浙江',value: 0 },
                {name: '江西',value: 0 },
                {name: '山西',value: renshuData[2] },
                {name: '甘肃',value: 0 },
                {name: '青海',value: 0 },
                {name: '黑龙江',value: renshuData[7] },
                {name: '辽宁',value: 0 },
                {name: '山东',value: renshuData[1]},
                {name: '江苏',value: 0 },
                {name: '河南',value: renshuData[4] },
                {name: '陕西',value: renshuData[6] },
                {name: '湖北',value: 0 },
                {name: '湖南',value: 0 },
                {name: '贵州',value: renshuData[5] },
                {name: '云南',value: randomData() },
                {name: '广西',value: 0 },
                {name: '台湾',value: 0 },
                {name: '海南',value: 0 },
                {name: '内蒙古',value: 0 },
                {name: '南海诸岛',value: 0 },
                {name: '吉林',value: 0 },
                {name: '福建',value: 0 },
                {name: '广东',value: 0 },
                {name: '西藏',value: 0 },
                {name: '四川',value: 0 },
                {name: '宁夏',value: 0 },
                {name: '香港',value: 0 },
                {name: '澳门',value: 0 }
            
            
            
            
            
            
            
            
            ]
        }
    ]
};
//为echarts对象加载数据
myChart.setOption(option);
</script>
</body>
</html>