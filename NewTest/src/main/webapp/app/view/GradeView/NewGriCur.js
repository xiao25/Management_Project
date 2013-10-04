/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/22/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.GradeView.NewGriCur",
    {
        extend: "Ext.form.Panel",


        alias: 'widget.NewGriCur',


        items: [
            {
                xtype: 'trigger',

                fieldLabel: '课程名称',

                emptyText: '选择课程',
                onTriggerClick: function () {

                    newview = Ext.create("HT.view.GradeView.StuIds"),

                        Ext.getStore("newone").load({params: {query: ""}});

                    newview.show();
                }



            }],
        buttons:[{

            text: '查询',
            name: 'submit'


        }]
    });


