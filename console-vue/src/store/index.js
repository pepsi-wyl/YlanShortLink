import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      // domain: 'nurl.ink'
      domain: 'yl.com:8001'
    }
  }
})

export default store
