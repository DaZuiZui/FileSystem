
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  //配置代理跨域
  devServer: {
    historyApiFallback: true,
    proxy: {
      "/api": {
        target: "http://127.0.0.1:8010/",
        ws:false,
        pathRewrite: {
          "^/api": "/"
        }
      },
    },
  },
  publicPath:'./',
  outputDir: "dist",
  assetsDir:"static",
})
