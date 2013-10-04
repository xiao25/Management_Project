/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/16/13
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.Loader.setConfig({enabled: true});
Ext.define('HT.controller.StudentController', {
    extend: 'Ext.app.Controller',
    views: [
        'HT.view.Accordion',
        'HT.view.Center',
        'HT.view.Top',
        'HT.view.Bottom',
        'HT.view.StudentView.Stuinfoadd',
        'HT.view.StudentView.Inqumethod',
        'HT.view.StudentView.UpdateStu',
        'HT.view.StudentView.operation_stu'
    ],
    stores: [
        'Students'
    ],
    models: [
        'Students'
    ],
    refs: [
        {
            ref: 'tab',

            selector: 'center'
        }
    ],
    init: function () {
        this.control({
            'center': {

                'beforeremove': function () {

                    Ext.getStore('Students').removeAll();
                    Ext.getStore('Courses').removeAll();
                    Ext.getStore('Grade').removeAll();
                    Ext.getStore('InquCur').removeAll();

                    Ext.getStore('CurNamestore').removeAll();
                    Ext.getStore('CurNumstore').removeAll();
                    Ext.getStore('StuNamestore').removeAll();
                }

            },

            'Inqumethod button[name = addmore]': {
                click: function () {


                    newview = Ext.create("HT.view.StudentView.Stuinfoadd"),
                        newview.show();
                    form = newview.down('form') ,
                        record = Ext.create('HT.model.Students'),
                        storenew = Ext.getStore("Students");
                    storenew.add(record);
                    form.loadRecord(record);
                }
            },
            'accordion button[name = Oeration_stu]': {
                click: function (o) {
                    if (Ext.ComponentQuery.query('Inqumethod').length == 0) {

                        this.getTab().add({
                            title: '学生信息',
                            id: 'inqstu',
                            layout: 'border',
                            items: [
                                {
                                    xtype: 'Inqumethod',
                                    region: 'north'




                                },
                                {
                                    xtype: 'operation_stu',
                                    region: 'center'


                                }

                            ],
                            closable: true,
                            closeAction: 'destroy',
                            autoDestory: true
                        });
                        Ext.ComponentQuery.query('operation_stu')[0].down('pagingtoolbar').moveFirst();
                        Ext.getStore("Students").load();
                        this.getTab().setActiveTab('inqstu');
                    }
                    else {

                        this.getTab().setActiveTab('inqstu');
                    }

                }
            },


            'Stuinfoadd button[name = Submit]': {
                click: function (button) {
                    var win = button.up('window');
                    var form = win.down('form');
                    if (form.getValues().addmore == 1) {
                        var record = form.getRecord();
                        values = form.getValues();

                        record.set(values);

                        // this.getStore('Students').loadData([record]);
                        this.getStore('Students').sync();
                        form.form.reset();
                        record = Ext.create('HT.model.Students'),
                            storenew = Ext.getStore("Students");
                        storenew.add(record);
                        form.loadRecord(record);

                    }
                    else {
                        var record = form.getRecord();
                        values = form.getValues();

                        record.set(values);
                        //this.getStore('Students').loadData([record]);
                        this.getStore('Students').sync();
                        form.close();
                        win.close();
                    }


                }
            },


            'Inqumethod button[name = submit]': {
                click: function (button) {
                    // var values = button.up('form').getValues();
                    Ext.getStore("Students").load();
                }

            },
            'Inqumethod button[name = delete]': {
                click: function (button) {
                    var checkbox = Ext.ComponentQuery.query('operation_stu')[0].getSelectionModel();
                    var array = checkbox.getSelection();
                    for (var i = 0; i < array.length; i++)
                        Ext.getStore("Students").remove(array[i]);
                    Ext.getStore('Students').sync();

                }
            },
            'Inqumethod button[name = update]': {
                click: function (button) {
                    var checkbox = Ext.ComponentQuery.query('operation_stu')[0].getSelectionModel();
                    var lastrecord = checkbox.getLastSelected().getData();

                    var newview = Ext.create("HT.view.StudentView.UpdateStu");
                    var form = newview.down('form');
                    form.query('textfield[name="stuname"]')[0].setValue(lastrecord.stuname);
                    form.query('datefield[name="birthday"]')[0].setValue(lastrecord.birthday);
                    form.query('textfield[name="phone"]')[0].setValue(lastrecord.phone);
                    form.query('textfield[name="address"]')[0].setValue(lastrecord.address);
                    form.query('textfield[name="id"]')[0].setValue(lastrecord.id);
                    form.query('textfield[name="stunum"]')[0].setValue(lastrecord.stunum);
                    form.query('htmleditor[name="remark"]')[0].setValue(lastrecord.remark);
                    form.query('combobox[name="classnum"]')[0].setValue(lastrecord.classnum);
                    if (lastrecord.sex == "女") {
                        form.query('radiogroup[name="sex"]')[0].items.items[0].setValue(false);
                        form.query('radiogroup[name="sex"]')[0].items.items[1].setValue(true);
                    }

                    newview.show();


                }
            },
            'UpdateStu button[name = Submit]': {
                click: function (button) {
                    var win = button.up('window');
                    var form = win.down('form');
                    var values = form.getValues();

                    Ext.Ajax.request({
                        async: false,
                        url: '/student/update.action',

                        params: {
                            data: Ext.encode(values)

                        },
                        method: 'POST',
                        success: function (response) {
                            var json = Ext.JSON.decode(response.responseText);
                            if (json.success == true) {
                                Ext.Msg.alert('通知', '更新成功');
                                Ext.getStore("Students").reload();
                                win.destroy();
                            }
                        }
                    })
                }
            }

        });
    }
})
