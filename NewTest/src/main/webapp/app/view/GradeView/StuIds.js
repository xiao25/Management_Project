/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/10/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.GradeView.StuIds",
    {
        extend: "Ext.window.Window",

        alias: 'widget.StuIds',
        height: 300,
        width: 300,
        reset: true,
        title: '成绩查询的课程选择',
        closable: true,
        resizable: false,
        items: [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'combobox',

                        queryMode: true,
                        editable: true,
                        hideTrigger: true,
                        queryParam: 'autoContent',


                        minChars: 1,
                        selectOnFocus: true,
                        forceSelection: true,
                        queryDelay: 700,
                        allowBlank: false,
                        fieldLabel: '课程名称',
                        store: 'CurNamestore',
                        displayField: 'name',
                        valueField: 'name',
                        triggerAction: 'all',
                        multiSelect: false,
                        value: "",

                        name: 'kcm'

                    }

                ],
                buttons: [
                    {

                        text: '完成选择',
                        name: 'finish',
                        defaultAlign: "br"
                    },

                    {
                        text: '查询',
                        name: 'submit',
                        defaultAlign: "br"
                    }
                ]

            },
            {
                xtype: 'grid',

                selModel: Ext.create('Ext.selection.CheckboxModel'),
                store: Ext.create('HT.store.CurNamestore', {
                    id: 'newone'
                }),
                scroll: true,
                multiSelect: true,
                columns: [

                    {
                        header: "课程名称",
                        width: 300,
                        sortable: true,
                        dataIndex: 'name'
                    }
                ]




            }


        ]

    });