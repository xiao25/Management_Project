/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/6/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.CourseView.CourseOperation", {
    extend: "Ext.grid.GridPanel",

    alias: "widget.CourseOperation",
    store: 'Courses',
    url: 'Course/update.action',

    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            store: "Courses",   // same store GridPanel is using
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
                {header: "课程号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'id'


                } ,


                {header: "课程名称",
                    width: 100,
                    sortable: true,
                    dataIndex: 'kcm'
                   // editor: 'textfield'
                },
                {header: "及格分数",
                    width: 100,
                    sortable: true,
                    dataIndex: 'ach'
                    //editor: 'textfield'
                },

                {header: "备注",
                    width: 300,
                    sortable: true,
                    dataIndex: 'remarks'
                    //editor: 'textfield'
                }


            ]




        ];


        this.callParent(arguments);
    }
});