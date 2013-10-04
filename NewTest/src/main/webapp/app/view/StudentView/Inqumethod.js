/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/26/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */



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


Ext.define("HT.view.StudentView.Inqumethod", {
    extend: 'Ext.form.Panel',
    alias: 'widget.Inqumethod',
    id: 'Inqumethod',
    dockedItems: [
{
    xtype: 'toolbar',
        dock: 'top',
    items: [

    { xtype: 'button', name: 'addmore', text: '添加' },
        { xtype: 'button', name: 'update', text: '修改' },
        { xtype: 'button', name: 'delete', text: '删除' }
    ]
    }],
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

                fieldLabel: '学生名称',
                store: 'StuNamestore',
                displayField: 'stuname',
                valueField: 'stuname',
                queryMode:true,
                multiSelect: false,
                value: "",
                editable: true,
                hideTrigger:true,
                queryParam:'autoContent',
                triggerAction:'all',

                minChars : 1,
                selectOnFocus : true,
                forceSelection:true,
                queryDelay : 700,
                name: 'stuname'
                //columnWidth: 1 / 3

            } ,
            {
                xtype: 'textfield',
                allowBlank: true,

                name: 'stunum',
                fieldLabel: '学生学号'
               // columnWidth: 1 / 3

            },
            {
                xtype: 'combobox',
                allowBlank: true,
                fieldLabel: '所在班级',
                store: combostore,
                displayField: 'name',
                valueField: 'id',
                triggerAction: 'all',

                value: "",
                editable: false,
                name: 'classnum',
                mode: 'local'
               // columnWidth: 1 / 3
            },

            {
                xtype: 'datefield',
                fieldLabel: '生日左界',
                name: 'birthday1',
                format: 'Y-m-d',
                editable: false,
                allowBlank: true
              //  columnWidth: 1 / 3


            },
            {
                xtype: 'datefield',
                fieldLabel: '生日右界',
                name: 'birthday2',
                format: 'Y-m-d',
                editable: false,
                allowBlank: true
             // columnWidth: 1 / 3

            }


        ];
        this.buttons = [
            {
                name: 'submit',
                text: '提交'
//                    action:'save'

            },


            {
                name: 'cancel',
                text: '取消',
                scope: this,
                handler: this.close


            }
        ];
        this.callParent(arguments);
    }
});