$( document ).ready( function () {
    $( "#commentForm" ).validate( {
        rules: {
            name: "required",
            address:{
                required: true
            }
        },
        messages: {
            name: "名称必须输入",
            address: {
                required: "地址必须输入"
            },
        },
        onfocusout:function(element){
            return $(element).valid();//手动校验当前失去焦点的element
        }
    } );
    $.validator.addMethod("checkQQ",function(value,element,params){
        var checkQQ = /^[1-9][0-9]{4,19}$/;
        return this.optional(element)||(checkQQ.test(value));
    },"*请输入正确的QQ号码！");

    $.validator.addMethod("checkEmail",function(value,element,params){
        var checkEmail = /^[a-z0-9]+@([a-z0-9]+\.)+[a-z]{2,4}$/i;
        return this.optional(element)||(checkEmail.test(value));
    },"*请输入正确的邮箱！");

    $.validator.addMethod("checkName",function(value,element,params){
        var checkName = /^\w{2,10}$/g;
        return this.optional(element)||(checkName.test(value));
    },"*只允许2-10位英文字母、数字或者下画线！");

    $.validator.addMethod("checkPwd",function(value,element,params){
        var checkPwd = /^\w{6,16}$/g;
        return this.optional(element)||(checkPwd.test(value));
    },"*只允许6-16位英文字母、数字或者下画线！");
} );