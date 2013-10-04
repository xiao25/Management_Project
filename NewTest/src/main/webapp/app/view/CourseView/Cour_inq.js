/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/4/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */




Ext.define("HT.view.CourseView.Cour_inq", {
    extend: 'Ext.form.Panel',
    alias: 'widget.Cour_inq',
    id: 'Cour_inq',
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [

                { xtype: 'button', name: 'add', text: '添加' },
                { xtype: 'button', name: 'update', text: '修改' },
                { xtype: 'button', name: 'delete', text: '删除' }

            ]
        }
    ],
    layout:'column',
    fieldDefaults: {
        labelWidth: 60,
        margin: 5  ,
        fieldWidth:100
    },
    initComponent: function () {

        this.items = [
            {
                xtype: 'combobox',

                allowBlank: true,
                queryMode:true,
                editable: true,
                hideTrigger:true,
                queryParam:'autoContent',
                triggerAction:'all',

                minChars : 1,
                selectOnFocus : true,
                forceSelection:true,
                queryDelay : 700,
                store: 'CurNamestore',
                displayField: 'name',
                valueField: 'name',

                multiSelect: false,
                value: "",

                name: 'kcm',
                fieldLabel: '课程名称'


            } ,
            {
                xtype: 'combobox',

                allowBlank: true,
                fieldLabel: '课程号',
                store: 'CurNumstore',
                displayField: 'id',
                valueField: 'id',
                triggerAction: 'all',
                multiSelect: false,
                value: "",
                editable: false,
                name: 'classnum'

            }


        ];
        this.buttons = [
            {
                name: 'submit',
                text: '提交'
//                    action:'save'

            }


        ];
//        Ext.getStore('CurNumstore').load();
        this.callParent(arguments);
    }
});