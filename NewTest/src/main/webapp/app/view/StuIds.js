/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/10/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.StuIds",
    {
        extend: "Ext.window.Window",

        alias: 'widget.StuIds',
        height: 200,
        width: 400,
        reset: true,
        title: '成绩查询的学生选择',
        closable: true,
        resizable: true,
        items: [
            {
                xtype: 'grid',
                dockedItems: [
                    {
                        xtype: 'toolbar',
                        dock: 'top',
                        items: [

                            { xtype: 'button', name: 'submit', text: '确认' }
                        ]
                    }
                ],
                selModel: Ext.create('Ext.selection.CheckboxModel'),
                store: Ext.create('Ext.data.Store', {
                    id: 'stuidstore',
                    autoloard: false,
                    fields: [
                        {name: 'stuid', type: 'int'},
                        {name: 'stuname', type: 'string'}
                    ],
                    proxy: {
                        type: 'ajax',
                        url: 'Student/viewstuid.action',

                        reader: {
                            type: 'json',

                            root: 'data',
                            success: 'success',
                            totalProperty: 'total'


                        }
                    }
                }),
                columns: [
                    {
                        header: "学生号",
                        width: 100,
                        sortable: true,
                        dataIndex: 'stuid'
                    },
                    {
                        header: "学生名称",
                        width: 100,
                        sortable: true,
                        dataIndex: 'stuname'
                    }
                ]




            },


//    {
//        xtype:'button',
//        name: 'submit',
//        text: '确认'
//    }


        ]
    });