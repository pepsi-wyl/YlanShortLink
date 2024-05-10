import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      // domain: 'nurl.ink'
      // dev
      domain: '127.0.0.1:8000'
      // K8s
      // domain: 'url.yl.com'
      // docker
      // domain: 'url.ylan.site'
    }
  }
})

export default store
