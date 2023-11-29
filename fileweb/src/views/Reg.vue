<template>
    <div class="box">
        <h2>Regsiter</h2>
        <div class="input-box">
            <label>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;:&nbsp;&nbsp;
                <input type="text" v-model="user.username"/></label>
        </div>
        <div class="input-box">

            <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;:&nbsp;&nbsp;
                <input type="text" v-model="user.password"/></label>
        </div>
        <div class="input-box">
            <label>确认密码&nbsp;:&nbsp;&nbsp;
                <input type="text" v-model="user.againPassword"/></label>
        </div>
        <div class="input-box">
            <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;:&nbsp;&nbsp;
                <input type="text" v-model="user.name"/></label>
        </div>
        <div class="input-box">
            <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;:&nbsp;&nbsp;
                <input type="text" v-model="user.studentId"/></label>
        </div>
        
        <div class="input-box">
            <label>
                年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级&nbsp;:&nbsp;&nbsp;            
            <el-select v-model="user.grade" placeholder="请选择">
                <el-option v-for="item in yearsList" :key="item" :label="item" :value="item">
                </el-option>
            </el-select>
            </label>
        </div>
        <div class="input-box">
            <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院&nbsp;:&nbsp;&nbsp;
                <el-select v-model="user.college" placeholder="请选择">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                            </el-select>
            </label>
            
        </div>
        
        <div class="input-box">
            <label>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业&nbsp;:&nbsp;&nbsp;
                <el-select v-model="user.professional" placeholder="请选择">

<el-option-group v-for="group in professionalList[user.college - 1]" :key="group.label"
    :label="group.label">

    <el-option v-for="item in group.professionalList" :key="item.professionalList"
        :label="item.label" :value="item">
    </el-option>
</el-option-group>
</el-select>
            </label>
            
        </div>

        <div class="btn-box">

            <div>
                <button @click="submit">登录</button>
                <button @click="submit">注册</button>
            </div>
        </div>
    </div>
</template> 
  
<script setup>
import { ref, reactive, onMounted } from 'vue';


const numYearsToShow = 5;
const options = [
    { value: 1, label: '信息学院' },
    { value: 2, label: '财经学院' },
    { value: 3, label: '艺术学院' },
    { value: 4, label: '通识学院' }
];
const professionalList = [
    //信息学院
    [
        {
            value: 1,
            label: '软件工程',
            professionalList: ['软件工程1班', '软件工程2班', '软件工程3班', '软件工程4班', '软件工程5班', '软件工程6班']
        }, {
            value: 2,
            label: '计算机科学与技术',
            professionalList: ['计算机科学与技术1班', '计算机科学与技术2班', '计算机科学与技术3班',
                '计算机科学与技术4班', '计算机科学与技术5班', '计算机科学与技术6班']
        }, {
            value: 3,
            label: '电子商务',
            professionalList: ['电子商务1班', '电子商务2班', '电子商务3班', '电子商务4班', '电子商务5班', '电子商务6班']
        },

    ],
    //财经学院
    [
        {
            value: 1,
            label: '审计学',
            professionalList: ['审计学1班', '审计学2班', '审计学3班', '审计学4班', '审计学5班', '审计学6班']
        }, {
            value: 2,
            label: '会计学',
            professionalList: ['会计学1班', '会计学2班', '会计学3班', '会计学4班', '会计学5班', '会计学6班']
        }, {
            value: 3,
            label: '国际经济与贸易',
            professionalList: ['国际经济与贸易1班', '国际经济与贸易2班', '国际经济与贸易3班',
                '国际经济与贸易4班', '国际经济与贸易5班', '国际经济与贸易6班']
        }, {
            value: 4,
            label: '财务管理',
            professionalList: ['财务管理1班', '财务管理2班', '财务管理3班', '财务管理4班', '财务管理5班', '财务管理6班']
        }, {
            value: 5,
            label: '工商管理',
            professionalList: ['工商管理1班', '工商管理2班', '工商管理3班', '工商管理4班', '工商管理5班', '工商管理6班']
        }, {
            value: 6,
            label: '人力资源管理',
            professionalList: ['人力资源管理1班', '人力资源管理2班', '人力资源管理3班',
                '人力资源管理4班', '人力资源管理5班', '人力资源管理6班']
        },

    ],
    //艺术学院
    [
        {
            value: 1,
            label: '视觉传达设计',
            professionalList: ['视觉传达设计1班', '视觉传达设计2班', '视觉传达设计3班',
                '视觉传达设计4班', '视觉传达设计5班', '视觉传达设计6班']
        }, {
            value: 2,
            label: '环境设计',
            professionalList: ['环境设计1班', '环境设计2班', '环境设计3班', '环境设计4班', '环境设计5班', '环境设计6班']
        }, {
            value: 3,
            label: '影视摄影与制作',
            professionalList: ['影视摄影与制作1班', '影视摄影与制作2班', '影视摄影与制作3班',
                '影视摄影与制作4班', '影视摄影与制作5班', '影视摄影与制作6班']
        },

    ],
    //通识学院
    [
        {
            value: 1,
            label: '汉语言文学',
            professionalList: ['汉语言文学1班', '汉语言文学2班', '汉语言文学3班',
                '汉语言文学4班', '汉语言文学5班', '汉语言文学6班']
        }, {
            value: 2,
            label: '应用心理学',
            professionalList: ['应用心理学1班', '应用心理学2班', '应用心理学3班',
                '应用心理学4班', '应用心理学5班', '应用心理学6班']
        }, {
            value: 3,
            label: '学前教育 (师范类)',
            professionalList: ['学前教育 (师范类)1班', '学前教育 (师范类)2班', '学前教育 (师范类)3班',
                '学前教育 (师范类)4班', '学前教育 (师范类)5班', '学前教育 (师范类)6班']

        },

    ]
]
const user = reactive({
    username: '',
    password: '',
    againPassword: '',
    name: '',
    college: '',
    org: '',
    grade: '',
    studentId: '',
    professional: ''
});
const input = ref('');
const switchbutton = ref(false);
const yearsList = ref([]);

onMounted(() => {
    const currentDate = new Date();
    const currentYear = currentDate.getFullYear();
    for (let i = currentYear - numYearsToShow + 1; i <= currentYear; i++) {
        yearsList.value.push(i);
    }
});

async function submit() {
    switchbutton.value = true;

    if (user.username === '') {
        alert('账号不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.password === '' || user.againPassword === '') {
        alert('密码不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.name === '') {
        alert('姓名不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.studentId === '') {
        alert('学号不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.grade === '') {
        alert('年级不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.college === '') {
        alert('学院不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.professional === '') {
        alert('专业不能为空');
        switchbutton.value = false;
        return;
    }

    if (user.password !== user.againPassword) {
        alert('密码设置失败');
        return;
    }

    console.log(user);
     const obj = await synRequestPost('/user/userReg', user);

     if (obj.code === '0x200') {
        $router.push('/login');
     }

    switchbutton.value = false;


}


</script>
  

<style scoped lang="less">
//   @h:#548655;
//   .i{
//     color: @h;
//     .b{
//         color: #000;
//     }
//   }

.el-select{
    width: 250px;
}
/deep/ .el-input__wrapper{
    box-sizing: border-box;
    color: rgba(255, 255, 255, 0.9);
    font-size: 14px;
    height: 35px;
    width: 250px;
    background: rgba(255, 255, 255, 0.3);
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-radius: 5px;
    transition: 0.2s;
    outline: none;
    padding: 0 10px;
    letter-spacing: 1px;
}
.Login {
    /* 实现水平垂直居中 */
    /* **display：flex**布局 justify-content定义水平方向的元素位置,align-items定义垂直方向的元素位置 */
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
}

.box {
    margin: 10% auto;
    flex-direction: column;
    border-radius: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 400px;
    height: 100%;
    border-top: 1px solid rgba(255, 255, 255, 0.5);
    border-left: 1px solid rgba(255, 255, 255, 0.5);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    border-right: 1px solid rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(10px);
    background: rgba(50, 50, 50, 0.2);
}

.box>h2 {
    color: rgba(77, 72, 72, 0.9);
    margin-bottom: 20px;
}

.box .input-box {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
    margin-bottom: 10px;
}

.box .input-box>label {
    margin-bottom: 5px;
    color: rgba(77, 72, 72, 0.9);
    font-size: 16px;
}

.box .input-box label>input {
    box-sizing: border-box;
    color: rgba(77, 72, 72, 0.9);
    font-size: 15px;
    height: 35px;
    width: 250px;
    background: rgba(255, 255, 255, 0.3);
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-radius: 5px;
    transition: 0.2s;
    outline: none;
    padding: 0 10px;
    letter-spacing: 1px;
}

.box .input-box>input:focus {
    border: 1px solid rgba(255, 255, 255, 0.8);
}

.box .btn-box {
    width: 250px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
    margin-bottom: 20px;
}

.box .btn-box>a {
    font-size: 14px;
    text-decoration: none;
    color: rgba(255, 255, 255, 0.9);
    transition: 0.2s;
    width: 250px;
    text-align: end;
}

.box .btn-box>a:hover {
    color: rgba(255, 255, 255, 1);
}

.box .btn-box>div {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: start;
    margin-top: 20px;
}

.box .btn-box>div>button {
    width: 120px;
    height: 35px;
    border: 1px solid rgba(197, 81, 58, 0.8);
    background: rgba(197, 81, 58, 0.5);
    color: rgba(255, 255, 255, 0.9);
    border-radius: 5px;
    transition: 0.2s;
}

.box .btn-box>div>button:nth-of-type(2) {
    margin-left: 10px;
}

.box .btn-box>div>button:hover {
    border: 1px solid rgba(248, 108, 76, 0.8);
    background: rgba(248, 108, 76, 0.5);
}
</style>
  