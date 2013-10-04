/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/10/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.







 */



Ext.define("HT.view.GradeView.inqstuname_form",
    {
        extend: "Ext.form.Panel",

        alias: 'widget.inqstuname_form',

        title: '成绩查询表',
        layout: 'column',
        fieldDefaults: {
            labelWidth: 60,
            margin: 5,
            fieldWidth: 100
        },
        items: [
            {
                xtype: 'combobox',
                allowBlank: false,
                queryMode: true,
                editable: true,
                hideTrigger: true,
                queryParam: 'autoContent',


                minChars: 1,
                selectOnFocus: true,
                forceSelection: true,
                queryDelay: 700,
                fieldLabel: '课程名称',
                store: 'CurNamestore',
                displayField: 'name',
                valueField: 'name',
                triggerAction: 'all',
                multiSelect: true,
                value: "",

                name: 'kcm'

            } ,
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
                allowBlank: true,
                fieldLabel: '学生名称',
                store: 'StuNamestore',
                displayField: 'stuname',
                valueField: 'stuname',
                triggerAction: 'all',
                multiSelect: true,
                value: "",

                name: 'stuname'

            }

        ],


        buttons: [
            {
                name: 'submit',
                text: '提交'


            }

        ]

    });
