// Detail.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Cassiopeia_313751158Doc.h"
#include "Detail.h"
#include "MenuAll.h"
#include <string.h>

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDetail

IMPLEMENT_DYNCREATE(CDetail, CFormView)

CDetail::CDetail()
	: CFormView(CDetail::IDD)
{
	//{{AFX_DATA_INIT(CDetail)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CDetail::~CDetail()
{
}

void CDetail::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CDetail)
	DDX_Control(pDX, IDC_DATETIMEPICKER1, m_timeStartD);
	DDX_Control(pDX, IDC_DATETIMEPICKER2, m_timeEndD);
	DDX_Control(pDX, IDC_LIST1, m_ctrList3);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CDetail, CFormView)
	//{{AFX_MSG_MAP(CDetail)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON3, OnButton3)
	ON_WM_CTLCOLOR()
	ON_BN_CLICKED(IDC_CHECK1, OnCheck1)
	ON_BN_CLICKED(IDC_CHECK2, OnCheck2)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDetail diagnostics

#ifdef _DEBUG
void CDetail::AssertValid() const
{
	CFormView::AssertValid();
}

void CDetail::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CDetail message handlers

CString CDetail::strVARIANT(const COleVariant& var)
{
    CString strRet;

    switch(var.vt)
    {
    case VT_EMPTY:
    case VT_NULL:
        strRet=_T("NULL");
        break;
    case VT_I2:
        strRet.Format(_T("%hd"),V_I2(&var));
        break;
    case VT_I4:
        strRet.Format(_T("%d"),V_I4(&var));
        break;
    case VT_R4:
        strRet.Format(_T("%e"),(double)V_R4(&var));
        break;
    case VT_R8:
        strRet.Format(_T("%e"),V_R8(&var));
        break;
    case VT_CY:
        strRet=COleCurrency(var).Format();
        break;
    case VT_DATE:
        strRet=COleDateTime(var).Format(_T("%m%d%y"));
        break;
    case VT_BSTR:
        strRet=V_BSTRT(&var);
        break;
    case VT_DISPATCH:
        strRet=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet=_T("VT_ERROR");
        break;
    case VT_BOOL:
        //return strBOOL(V_BOOL(&var));
    case VT_VARIANT:
        strRet=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet=_T("VT_I1");
        break;
    case VT_UI1:
        strRet.Format(_T("0x%02hX"),(unsigned short)V_UI1(&var));
        break;
    case VT_UI2:
        strRet=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet=_T("VT_UI4");
        break;
    case VT_I8:
        strRet=_T("VT_I8");
        break;
    case VT_UI8:
        strRet=_T("VT_UI8");
        break;
    case VT_INT:
        strRet=_T("VT_INT");
        break;
    case VT_UINT:
        strRet=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet=_T("VT_CLSID");
        break;
	}
	
	WORD vt=var.vt;
	
	if(vt&VT_ARRAY)
	{
		vt=vt&~VT_ARRAY;
		strRet=_T("Array of");
	}
	
	if(vt&VT_BYREF)
	{
		vt=vt&~VT_BYREF;
		strRet+=_T("Pointer to");
	}

	if(vt!=var.vt)
	{	
		switch(vt)
		{
		case VT_EMPTY:
		    strRet+=_T("VT_EMPTY");
		    break;
		case VT_NULL:
		  strRet+=_T("VT_NULL");
	        break;
		case VT_I2:
			strRet+=_T("VT_I2");
			break;
		case VT_I4:
			strRet+=_T("VT_I4");
			break;
		case VT_R4:
        strRet+=_T("VT_R4");
        break;
    case VT_R8:
        strRet+=_T("VT_r8");
        break;
    case VT_CY:
        strRet+=_T("VT_CY");
        break;
    case VT_DATE:
        strRet+=_T("VT_DATE");
        break;
    case VT_BSTR:
        strRet+=_T("VT_BSTR");
        break;
    case VT_DISPATCH:
        strRet+=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet+=_T("VT_ERROR");
        break;
    case VT_BOOL:
        strRet+=_T("VT_BOOL");
        break;
    case VT_VARIANT:
        strRet+=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet+=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet+=_T("VT_I1");
        break;
    case VT_UI1:
        strRet+=_T("VT_UI1");
        break;
    case VT_UI2:
        strRet+=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet+=_T("VT_UI4");
        break;
    case VT_I8:
        strRet+=_T("VT_I8");
        break;
    case VT_UI8:
        strRet+=_T("VT_UI8");
        break;
    case VT_INT:
        strRet+=_T("VT_INT");
        break;
    case VT_UINT:
        strRet+=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet+=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet+=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet+=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet+=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet+=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet+=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet+=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet+=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet+=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet+=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet+=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet+=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet+=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet+=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet+=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet+=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet+=_T("VT_CLSID");
        break;
		}
	}

	return strRet;
}


void CDetail::OnButton2() 
{
	// TODO: Add your control notification handler code here

	CMenuAll dlg;
	dlg.DoModal();
}

void CDetail::OnButton1() 
{
	// TODO: Add your control notification handler code here
	if(!m_pDatabase->IsOpen()) return;
	if(!m_pRecordset)		   return;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	
	UpdateData(true);
	
	m_ctrList3.DeleteAllItems();
	CTime tm1;
	CString Date1;
	m_timeStartD.GetTime(tm1);//m_time为你的时间选择器的CTime类型的变量获取时间到tm中
	Date1=tm1.Format("%Y-%m-%d");//转化成CString类型
	CTime tm2;
	CString Date2;
	m_timeEndD.GetTime(tm2);//m_time为你的时间选择器的CTime类型的变量获取时间到tm中
	Date2=tm2.Format("%Y-%m-%d");//转化成CString类型
	CString strSelect;

	if (((check1%2)==0&&(check2%2)==0)||((check2%2)!=0&&(check2%2)!=0))
	{
		strSelect.Format("SELECT * FROM student_info_table WHERE 日期判 between #%s# and #%s# and 姓名='%s' ",
		Date1,Date2,IDName);
	}

	if (check1%2!=0&&check2%2==0)
	{
		CString shou;
		shou="收入";
		strSelect.Format("SELECT * FROM student_info_table WHERE 日期判 between #%s# and #%s# and 类型='%s' and 姓名='%s' ",
		Date1,Date2,shou,IDName);
	}

	if (check1%2==0&&check2%2!=0)
	{
		CString zhi;
		zhi="支出";
		strSelect.Format("SELECT * FROM student_info_table WHERE 日期判 between #%s# and #%s# and 类型='%s' and 姓名='%s' ",
		Date1,Date2,zhi,IDName);
	}
	
	
	int nItem = 0;
	try{			// 取记录集的数据
		m_pRecordset->Open(dbOpenDynaset,strSelect);
		
		while (!m_pRecordset->IsEOF()) {
			COleVariant var;
			var = m_pRecordset->GetFieldValue(0);
			m_ctrList3.InsertItem(nItem,strVARIANT(var));
			for (int i=0; i < 6; i++){
				var = m_pRecordset->GetFieldValue(i);
				m_ctrList3.SetItemText( nItem,i,strVARIANT(var));
			}
			nItem++;
			m_pRecordset->MoveNext();
		}
	}
	
	catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return;
	}
}

void CDetail::OnInitialUpdate() 
{
	CFormView::OnInitialUpdate();

	check1=0;
	check2=0;

	
	// TODO: Add your specialized code here and/or call the base class
	CString strFileName="TVXQ_Save_1997.mdb"; //获取文件名以及路径名
	m_DBFileName = strFileName;
	//	m_strStatic1 = strFileName;
	UpdateData(false);

	
	//打开数据库，创建记录集合对象
	m_pDatabase = new CDaoDatabase;
	try{
		m_pDatabase->Open(m_DBFileName);
		m_pRecordset = new CDaoRecordset(m_pDatabase);
		m_ctrList3.EnableWindow(true);
	}
	catch (CDaoException* e){
		e->ReportError();
		delete m_pDatabase;
		m_pDatabase = NULL;
		e->Delete();
		return;
	}

	
	UpdateView();  //在这函数中读取数据库
					//并更新ListView
}


bool CDetail::UpdateView()
{
	//显示部分：清除当前的List
	m_ctrList3.EnableWindow(true);
	m_ctrList3.DeleteAllItems();
	while (m_ctrList3.DeleteColumn(0))
	{
		m_ctrList3.DeleteColumn(0);
	}
	int nListCol = m_ctrList3.GetHeaderCtrl()->GetItemCount();//获取列数量
	if (nListCol > 0)
	{	for (int i=0;i<nListCol;i++)
	{	m_ctrList3.DeleteColumn(i);
	}
	}
	
	//读取数据库中的“student_info_table”表的结构
	//写入FormView中的CListCtrl控件中。
	m_strTableName = _T("student_info_table");	// 设置当前操作的数据库表名称
	int nFields;
	CDaoFieldInfo fieldInfo;			// 取表的结构信息
	CDaoTableDef td(m_pDatabase);		// 表对象
	
	try{
		td.Open(m_strTableName);		//打开指定名称的表
		nFields = td.GetFieldCount()-3;	//获取该表的栏数
		for (int j=0; j < nFields; j++){
			td.GetFieldInfo(j,fieldInfo); //获取每个栏的信息
			int nWidth = m_ctrList3.GetStringWidth(fieldInfo.m_strName) + 15;
			m_ctrList3.InsertColumn(j,fieldInfo.m_strName,LVCFMT_LEFT, nWidth);
		}
	}catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return false;
	}
	td.Close();

	
	
	//读取表的数据，写入FormView中的CListCtrl控件中。
	int nItem = 0;
	try{
		//拼一个SQL查询语句：select * from [student_info_table]
		CString strSelect(_T("Select * From ["));
		strSelect += m_strTableName;
		strSelect += _T("]");   

		strSelect.Format("SELECT * FROM student_info_table WHERE 姓名='%s' ",
		IDName);
		//指定m_pRecordset类型为动态类型,同时查询
		m_pRecordset->Open(dbOpenDynaset,strSelect);
		
		while (!m_pRecordset->IsEOF()) 
		{
			COleVariant var;
			var = m_pRecordset->GetFieldValue(0); //第0列
			m_ctrList3.InsertItem(nItem,strVARIANT(var));
			for (int i=0; i < nFields; i++){
				var = m_pRecordset->GetFieldValue(i);
				CString strItem = strVARIANT(var);
				int width1 = m_ctrList3.GetColumnWidth(i);
				int width2 = m_ctrList3.GetStringWidth(strItem)+15;
				if (width2 > width1){
					m_ctrList3.SetColumnWidth(i,width2);
				}
				m_ctrList3.SetItemText( nItem,i,strItem);
			}
			nItem++;
			m_pRecordset->MoveNext();
		}
	}
	catch (CDaoException* e)
	{
		e->ReportError(); 
	e->Delete();
		return false;
	}
	
	return true;
}

void CDetail::OnButton3() 
{
	// TODO: Add your control notification handler code here
		CString strFileName="TVXQ_Save_1997.mdb"; //获取文件名以及路径名
		m_DBFileName = strFileName;
		UpdateData(false);

	
	//打开数据库，创建记录集合对象
	m_pDatabase = new CDaoDatabase;
	try{
		m_pDatabase->Open(m_DBFileName);
		m_pRecordset = new CDaoRecordset(m_pDatabase);
		m_ctrList3.EnableWindow(true);
	}
	catch (CDaoException* e){
		e->ReportError();
		delete m_pDatabase;
		m_pDatabase = NULL;
		e->Delete();
		return;
	}

	
	UpdateView();  //在这函数中读取数据库
					//并更新ListView
}




void CDetail::OnCheck1() 
{
	// TODO: Add your control notification handler code here
	check1=check1+1;
}

void CDetail::OnCheck2() 
{
	// TODO: Add your control notification handler code here
	check2=check2+1;
}

HBRUSH CDetail::OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor) 
{
	HBRUSH hbr = CFormView::OnCtlColor(pDC, pWnd, nCtlColor);
	
	// TODO: Change any attributes of the DC here
	if (pWnd->GetDlgCtrlID()==(IDC_STATIC_2))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(246,129,120));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_STATIC_1))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(246,129,120));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_CHECK1))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(246,129,120));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

		if (pWnd->GetDlgCtrlID()==(IDC_CHECK2))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(246,129,120));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}


	// TODO: Return a different brush if the default is not desired
	return hbr;
}
