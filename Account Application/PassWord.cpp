// PassWord.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "PassWord.h"
#include "Login.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CPassWord dialog


CPassWord::CPassWord(CWnd* pParent /*=NULL*/)
	: CDialog(CPassWord::IDD, pParent)
{
	//{{AFX_DATA_INIT(CPassWord)
	m_strSurePassword = _T("");
	m_strNewPassword = _T("");
	//}}AFX_DATA_INIT
}


void CPassWord::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CPassWord)
	DDX_Text(pDX, IDC_EDIT2, m_strSurePassword);
	DDX_Text(pDX, IDC_EDIT1, m_strNewPassword);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CPassWord, CDialog)
	//{{AFX_MSG_MAP(CPassWord)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CPassWord message handlers

void CPassWord::OnButton1() 
{
	//确认
	UpdateData(true);
	CString Filepath="TVXQ_Data.mdb";
	CString SnameN,Spsw;
	_variant_t varname,varpsw;
	CDaoRecordset DbSet(&TVXQ);
	TVXQ.Open(Filepath);
	DbSet.Open(AFX_DAO_USE_DEFAULT_TYPE,"SELECT * FROM DataTable",0);
	varname=DbSet.GetFieldValue("Name");
	varpsw=DbSet.GetFieldValue("Psw");
	SnameN=(LPCSTR)_bstr_t(varname);
	Spsw=(LPCSTR)_bstr_t(varpsw);
	UpdateData(0);

	if(m_strNewPassword.IsEmpty()||m_strSurePassword.IsEmpty())
	{
		MessageBox("信息不能为空","采花大豆·记账");
		DbSet.Close();
		TVXQ.Close();
		return;
	}
	else if (m_strSurePassword!=m_strNewPassword)
	{
		UpdateData(1);
		MessageBox("新密码输入不一致","采花大豆·记账");
		m_strNewPassword="";
		m_strSurePassword="";
		UpdateData(0);
		DbSet.Close();
		TVXQ.Close();
		return;
	}
	else
	{
		while (IDName!=SnameN)
		{
			varname=DbSet.GetFieldValue("Name");
			SnameN=(LPCSTR)_bstr_t(varname);
			DbSet.MoveNext();
		}
		UpdateData(1);
		DbSet.MovePrev();
		DbSet.Edit();
		DbSet.SetFieldValue("Psw",_variant_t(m_strSurePassword));
		DbSet.Update();
		CPassWord::OnCancel();
		MessageBox("真的！真的！修改成功了！","采花大豆·记账");
		UpdateData(0);
		DbSet.Close();
		TVXQ.Close();
	}
			
	
	
/*	else
				{	
					UpdateData(1);
					MessageBox("修改成功");
				//	CDialog::OnCancel();
					DbSet.Edit();
					DbSet.SetFieldValue("Psw",_variant_t(m_strNewPassword));
					DbSet.Update();
					m_strNewPassword="";
					m_strSurePassword="";
					CPassWord::OnCancel();
				//	CLogin dlgAbout;
				//	dlgAbout.DoModal();
					UpdateData(0);
					DbSet.Close();
	                TVXQ.Close();
					return;
				}		
*/	
}
