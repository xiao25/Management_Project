/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/8/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
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
Ext.define("HT.view.GradeView.GradAdd",
    {
        extend: "Ext.window.Window",

        alias: 'widget.GradAdd',
        url: '/Grade/create.action',
        height: 300,
        width: 700,
        reset: true,
        title: '成绩信息添加表',
        closable: true,
        resizable: false,
        layout: 'border',
        modal: true,

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
                                xtype: 'combobox',

                                allowBlank: true,
                                fieldLabel: '按课程号查找',
                                store: 'CurNumstore',
                                displayField: 'id',
                                valueField: 'id',
                                triggerAction: 'all',
                                multiSelect: false,
                                value: "",
                                editable: false,
                                name: 'classnum'

                            },

                            {
                                xtype: 'textfield',
                                fieldLabel: '学生学号',
                                name: 'stunum',
                                value: '60',
                                columnWidth: 1 / 3
                            },
                            {

                                xtype: 'numberfield',
                                fieldLabel: '成绩',

                                name: 'ach',
                                columnWidth: 1 / 3
                            }


                        ]
                    },
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
                name: 'submit',
                text: '提交',
                action: 'save'

            }


        ]


    });

