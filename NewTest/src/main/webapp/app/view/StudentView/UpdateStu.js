/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/17/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
    //初始化标签中的Ext:Qtip属性。
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'side';

//------------第一列内容开始-------------//
//姓名

//班级数据源
var combostore = Ext.create('Ext.data.ArrayStore', {
    fields: ['id', 'name'],
    data: [
        ['一班', '一班'],
        ['二班', '二班'],
        ['三班', '三班'],
        ['四班', '四班'],
        ['五班', '五班'],
        [6, '不选']
    ]
});


// 表单
Ext.define("HT.view.StudentView.UpdateStu",
    {
        extend: "Ext.window.Window",

        alias: 'widget.UpdateStu',
        url: 'student/create.action',
        height: 400,
        width: 700,
        reset: true,
        title: '学生信息添加表',
        closable: true,
        resizable: false,
        layout: 'border',
        modal:true,

        buttonAlign: 'center',
        items: [
            {

                xtype: 'form',
                region: 'center',
                /*layout:'column',*/
                fieldDefaults: {
                    labelWidth: 60,
                    margin: 5
                },
                items: [
                    {
                        layout: 'column',
                        xtype: 'container',
                        items: [
                            {
                                xtype: 'textfield',
                                allowBlank: false,

                                name: 'stunum',
                                fieldLabel: '学号',
                                blankText: '请输入学号',

                                columnWidth: 1 / 3
                            },
                            {
                                xtype: 'textfield',
                                allowBlank: false,
                                maxLength: 8,
                                name: 'stuname',
                                fieldLabel: '姓名',
                                blankText: '请输入姓名',
                                maxLengthText: '姓名不能超过8个字符',
                                columnWidth: 1 / 3
                            },


                            {
                                xtype: 'datefield',
                                fieldLabel: '出生年月',
                                name: 'birthday',
                                format: 'Y-m-d',
                                editable: false,
                                allowBlank: false,
                                blankText: '请选择出生日期',
                                columnWidth: 1 / 3
                            }
                        ]
                    },
                    {
                        layout: "column",
                        xtype: 'container',
                        items: [
                            {
                                xtype: 'combobox',
                                allowBlank: false,
                                fieldLabel: '所在班级',
                                store: combostore,
                                displayField: 'name',
                                valueField: 'id',
                                triggerAction: 'all',
                                emptyText: '请选择...',
                                blankText: '请选择所在班级',
                                editable: false,
                                name: 'classnum',
                                mode: 'local',
                                columnWidth: 1 / 3
                            },

                            {
                                //联系电话
                                xtype: 'textfield',
                                allowBlank: false,
                                maxLength: 20,
                                name: 'phone',
                                fieldLabel: '联系电话',
                                blankText: '请输入联系电话',
                                maxLengthText: '联系电话不能超过20个字符',
                                columnWidth: 1 / 3

                            },
                            {
                                //通信地址
                                xtype: "textfield",
                                allowBlank: false,
                                maxLength: 60,
                                name: 'address',
                                fieldLabel: '通信地址',
                                blankText: '请输入通信地址',
                                maxLengthText: '通信地址不能超过60个字符',
                                columnWidth: 1 / 3
                            }
                        ]
                    },
                    {

                        xtype: 'radiogroup',
                        fieldLabel: '性别',
                        name:'sex',
                        items: [
                            { name: 'sex', inputValue: '男', boxLabel: '男', checked: true},
                            { name: 'sex', inputValue: '女', boxLabel: '女'}
                        ],
                        columnWidth: 1 / 3
                    },

                    {
                        xtype: "htmleditor",
                        fieldLabel: '评语',
                        name: 'remark',
                        height: 180,
                        width: '98%'
                        //columnWidth:1
                    } ,
                    {
                        //id
                        xtype: "textfield",
                        allowBlank: true,
                        hidden:true,

                        name: 'id',
                        width:'20%',
                        height:30

                    }

                ]


            }
        ],
        buttons: [
            {
                name: 'Submit',
                text: '提交',
                action: 'save'

            }

//
//            {
//                name: 'Cancel',
//                text: '重置',
//                scope: this,
//                handler: this.close
//
//
//            }
        ]
        /*        initComponent: function () {

         this.;

         this.callParent(arguments);

         }*/

    });

