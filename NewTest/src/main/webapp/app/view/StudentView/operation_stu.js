/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/2/13
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.StudentView.operation_stu", {
    extend: "Ext.grid.GridPanel",

    alias: "widget.operation_stu",
    store: 'Students',

    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            store: "Students",   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"

        }

    ],
    selModel: Ext.create('Ext.selection.CheckboxModel') ,


    initComponent: function () {


        items = [



            this.columns = [
                {
                    header: "学号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stunum',
                    allowBlank: false


                } ,

                {
                    header: "姓名",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stuname',
                    allowBlank: false


                } ,


                {
                    header: "电话",
                    width: 100,
                    sortable: true,
                    dataIndex: 'phone'

                },
                {header: "班级",
                    width: 100,
                    sortable: true,
                    dataIndex: 'classnum'


                },
                {header: "生日",
                    width: 100,
                    sortable: true,
                    dataIndex: 'birthday'


                }  ,
                {header: "地址",
                    width: 100,
                    sortable: true,
                    dataIndex: 'address'


                } ,
                {header: "性别",
                    width: 100,
                    sortable: true,
                    dataIndex: 'sex'


                }   ,
                {header: "评语",
                    width: 200,
                    sortable: true,
                    dataIndex: 'remark'


                }



            ]




        ];


        this.callParent(arguments);
    }
});