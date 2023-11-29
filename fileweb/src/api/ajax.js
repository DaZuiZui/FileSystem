
import axios  from "axios";

const requests = axios.create({
    //配置对象
    //基础路径,发请求的时候,路径当中会出现api
    baseURL:'/',
    //代表请求超时的时间5S
    timeout:5000,

});

//请求拦截器.在发送请求之前,请求拦截器可以检测到,可以在请求发出去之前做一些事情



//对外暴露
export default requests;
