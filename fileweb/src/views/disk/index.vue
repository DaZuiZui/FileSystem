<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-30 22:29:03
 * @LastEditTime: 2023-12-03 19:28:25
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /fileweb/src/views/disk/index.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <el-upload
   
    class="upload-demo"
    action="/api/file/imgUpDown"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :before-remove="beforeRemove"
  >
    <el-button type="primary">Click to upload</el-button>
    <template #tip>
      <div class="el-upload__tip">
        jpg/png files with a size less than 500KB.
      </div>
    </template>
  </el-upload>
</template>
<script setup>
import { ElMessage, ElMessageBox } from 'element-plus'
import { useCookies } from "vue3-cookies";
import { ref, reactive, onMounted, toRefs, computed } from 'vue';

const { cookies } = useCookies();
const token = cookies.get('token')
// import  { UploadProps, UploadUserFile } from 'element-plus'

onMounted(()=>{
  //eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJxZHNxZHEiLCJpYXQiOjE3MDE1ODY0MTYsInN1YiI6ImFzZHF3c2RxcyIsImV4cCI6MTcwMjE5MTIxNiwiaWQiOiIzIn0.a0BLhov3nkG9Yrnkemc6LrwYTEgnCbKk2KJLTUmCGQU
  //eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJxZHNxZHEiLCJpYXQiOjE3MDE1ODY0MTYsInN1YiI6ImFzZHF3c2RxcyIsImV4cCI6MTcwMjE5MTIxNiwiaWQiOiIzIn0.a0BLhov3nkG9Yrnkemc6LrwYTEgnCbKk2KJLTUmCGQU
console.log(token);
})
const handleRemove = (file, uploadFiles) => {
  console.log(file, uploadFiles)
}

const handlePreview= (uploadFile) => {
  console.log(uploadFile)
}

const beforeRemove= (uploadFile, uploadFiles) => {
  return ElMessageBox.confirm(
    `Cancel the transfer of ${uploadFile.name} ?`
  ).then(
    () => true,
    () => false
  )
}

</script>

<style lang="less" scoped>

</style>