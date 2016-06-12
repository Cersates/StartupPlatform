body {
    width: 999px;
    margin: 0 auto;
    min-height: 100%;
    height: auto !important;
}

.layout {
    width: 999px;
    margin: auto;
}

section {
    margin: 20px 0;
}

.radial {
    -moz-border-radius-topleft: 10px;
    -moz-border-radius-topright: 10px;
    -moz-border-radius-bottomleft: 10px;
    -moz-border-radius-bottomright: 10px;
    -webkit-border-top-left-radius: 10px;
    -webkit-border-top-right-radius: 10px;
    -webkit-border-bottom-left-radius: 10px;
    -webkit-border-bottom-right-radius: 10px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}

.error {
    color: red;
}
/* Header
-----------------------------------------------------------------------------*/
.header {
    height: 150px;
    background: #87CEFA;
}


/* Middle
-----------------------------------------------------------------------------*/
.middle {
    min-height: 100%;
    background: #FFFFFF;
    width: 100%;
    padding: 0 0 100px;
    position: relative;

    font-family: "Arial";
    font-size: 20px;
    color: #330066;
    /*border-color: #330066;
    border-width: 1px 1px 1px 1px;
    border-style: solid;*/
}
.middle:after {
    display: table;
    clear: both;
    content: '';
}
.container {
    width: 100%;
    float: left;
    overflow: hidden;
}
.content {
    padding: 0 0 0 270px;
}


/* Left Sidebar
-----------------------------------------------------------------------------*/
.left-sidebar {
    float: left;
    width: 265px;
    margin-left: -100%;
    position: relative;
    font-size: 14px;
    /*background: #B5E3FF;*/
}

/* Footer
-----------------------------------------------------------------------------*/
.footer {
    bottom: 0;
    /*height: 80px;*/
    position: absolute;

    width: 999px;
    margin: -100px auto 0;

    /*background: #BFF08E;*/
    /*position: relative;*/

    font-family: "Arial";
    font-size: 15px;
    color: #330066;
    background: #FFFFFF;

    border-color: #330066;
    border-width: 1px 0px 0px 0px;
    border-style: solid;
    /* border-color: #330066;
     border-width: 1px 1px 1px 1px;
     border-style: solid;
    */
    text-align: right;
}


.main-menu{
    /*width:180px;*/
    padding:0;
    margin:0;
    list-style:none;
}
.main-menu a{
    display:block;
    padding:8px 14px;
    margin-bottom:-1px;
    color:#330066;
    text-decoration:none;
    border:1px solid #E5E5E5;
}
.main-menu a:hover{
    background:#660099;
    color:#FFF;
}
.main-menu>li{

}
/* подменю */
.main-menu .sub-menu{
    padding:0;
    margin:0;
    list-style:none;
    background:#FCF8E3;
}
body{
    font-family:Arial, sans-serif;
    font-size:14px;
    line-height:1.4;
    padding:10px;
    background-color: #D3D3D3;
    /*background-image: url("../images/background.jpg");*/
}

* {
    margin: 0;
    padding: 0;
}
html {height: 100%;}
* html body {height: 100%;}
body {
    min-height: 100%;
    position: relative;
}