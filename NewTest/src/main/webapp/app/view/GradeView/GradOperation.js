/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */


Ext.define("HT.view.GradeView.GradOperation", {
    extend: "Ext.grid.GridPanel",

    alias: "widget.GradOperation",
    store: 'Grade',
    url: 'Grade/update.action',
    selType: 'cellmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            store: "Grade",   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"

        }
    ],
    selModel: Ext.create('Ext.selection.CheckboxModel'),
    initComponent: function () {


        items = [



            this.columns = [
                {header: "id号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'id'


                } ,


                {header: "课程号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'curid'

                },
                {header: "课程名称",
                    width: 100,
                    sortable: true,
                    dataIndex: 'kcm'

                },
                {header: "学号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stuid'

                },
                {header: "学生姓名",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stuname'

                },

                {header: "成绩",
                    width: 100,
                    sortable: true,
                    dataIndex: 'ach',
                    editor: 'textfield'
                } ,
                {xtype: 'rownumberer', header: '名次', width: 100}


            ]




        ];


        this.callParent(arguments);
    }
});
