/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/10/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.







 */


Ext.define("HT.view.GradeView.GridinqByCur_form",
    {
        extend: "Ext.form.Panel",

        alias: 'widget.GridinqByCur_form',

        title: '成绩查询表',
        id: 'GridinqByCur_form',
        layout: 'column',
        fieldDefaults: {
            labelWidth: 60,
            margin: 5,
            fieldWidth: 100
        },
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
                name: 'submit',
                text: '提交'


            }


        ]

    });
