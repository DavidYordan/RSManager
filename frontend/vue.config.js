module.exports = {
    // 配置页面标题和入口文件
    pages: {
      index: {
        entry: 'src/main.js',
        title: 'Enterprise Management Platform', // 网站标题，可根据需要修改
      },
    },
    // 配置开发服务器
    devServer: {
      historyApiFallback: true, // 支持 history 模式的路由
    },
    // 其他配置（如有需要）
    // 配置 webpack，解析别名等
    configureWebpack: {
      // 添加您的 webpack 配置
    },
  };
  