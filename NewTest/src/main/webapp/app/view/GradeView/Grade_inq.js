/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.GradeView.Grade_inq", {
    extend: 'Ext.form.Panel',
    alias: 'widget.Grade_inq',
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [

                { xtype: 'button', name: 'add', text: '添加' } ,
                { xtype: 'button', name: 'delete', text: '删除' }

            ]
        }
    ],
    layout: 'column',
    fieldDefaults: {
        labelWidth: 60,
        margin: 5,
        fieldWidth: 100
    },
    initComponent: function () {

        this.items = [
            {
                xtype: 'textfield',
                allowBlank: true,

                name: 'id',
                fieldLabel: 'ID号查询'


            }


        ];
        this.buttons = [
            {
                name: 'submit',
                text: '提交'
//                    action:'save'

            }


        ];

        this.callParent(arguments);
    }
});