/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/19/13
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.CourseView.UpdateCour",
    {
        extend: "Ext.window.Window",

        alias: 'widget.UpdateCour',
        url: '/Course/update.action',
        height: 300,
        width: 700,
        reset: true,
        title: '课程信息修改表',
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


    });
