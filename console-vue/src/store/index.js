import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      // domain: 'nurl.ink'
      // dev
      domain: 'url.yl.com:8000'
      // prod
      // domain: 'url.yl.com'
    }
  }
})

export default store
