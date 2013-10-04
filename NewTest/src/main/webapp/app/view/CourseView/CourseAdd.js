/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/6/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
//初始化标签中的Ext:Qtip属性。
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'side';


// 表单
Ext.define("HT.view.CourseView.CourseAdd",
    {
        extend: "Ext.window.Window",

        alias: 'widget.CourseAdd',
        url: '/Course/create.action',
        height: 350,
        width: 700,
        reset: true,
        title: '课程信息添加表',
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
                                maxLength: 8,
                                name: 'id',
                                fieldLabel: '课程号',
                                blankText: '请输入课程号',

                                columnWidth: 1 / 3
                            },
                            {

                                xtype: 'textfield',
                                fieldLabel: '课程名称',

                                name: 'kcm',
                                columnWidth: 1 / 3
                            },

                            {
                                xtype: 'numberfield',
                                fieldLabel: '及格分数',
                                name: 'ach',

                                step: 5,
                                value: 60,
                                columnWidth: 1 / 3
                            }
                        ]
                    },


                    {
                        xtype: "htmleditor",
                        fieldLabel: '备注',
                        name: 'remarks',
                        height: 180,
                        width: '98%'
                        //columnWidth:1
                    } ,
                    {
                        xtype: 'checkbox',
                        boxLabel: '连续添加',
                        inputValue: '1',
                        width: 300,
                        name: "addmore",
                        checked: true
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


        ]
        /*        initComponent: function () {

         this.;

         this.callParent(arguments);

         }*/

    });

