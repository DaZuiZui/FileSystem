
import requests from "./ajax";


export const login = (username,password) => requests({ url: `api/user/login`, method: 'post',data:{username,password}});

